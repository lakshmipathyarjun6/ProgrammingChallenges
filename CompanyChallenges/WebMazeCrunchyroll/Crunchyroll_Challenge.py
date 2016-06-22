import urllib2
import json

url_num = 9371810

s = ""
operator_stack = []
operand_stack = []
address_queue = []
history_queue = []
temp_queue = []
temp_queue_DFS = []
path_dict = {}
cycle_dict = {}
operator_string = ""
cycle_count = 0
goal_url = 0
num_nodes = 0

starting_node = url_num

# Breadth first search to find shortest path between start and goal
def find_shortest_path(graph, start, end, path=[]):
    path = path + [start]
    if start == end:
        return path
    if not graph.has_key(start):
        return None
    shortest = None
    for node in graph[start]:
        if node not in path:
            newpath = find_shortest_path(graph, node, end, path)
            if newpath:
                if not shortest or len(newpath) < len(shortest):
                    shortest = newpath
    return shortest

# Find all strongly connected components using Tarjan's algorithm
def strongly_connected_components(graph):
    index_counter = [0]
    stack = []
    lowlinks = {}
    index = {}
    result = []
    
    def strongconnect(node):
        # set the depth index for this node to the smallest unused index
        index[node] = index_counter[0]
        lowlinks[node] = index_counter[0]
        index_counter[0] = index_counter[0] + 1
        stack.append(node)
        
        # Consider successors of `node`
        try:
            successors = graph[node]
        except:
            successors = []
        for successor in successors:
            if successor not in lowlinks:
                # Successor has not yet been visited, so process it
                strongconnect(successor)
                lowlinks[node] = min(lowlinks[node],lowlinks[successor])
            elif successor in stack:
                # the successor is in the stack and hence in the current strongly connected component (the current subgraph)
                lowlinks[node] = min(lowlinks[node],index[successor])
        
        # If `node` is a root node, pop it off the stack and consider it a strongly connected component
        if lowlinks[node] == index[node]:
            connected_component = []
            
            while True:
                successor = stack.pop()
                connected_component.append(successor)
                if successor == node: break
        # return result as a tuple
            component = tuple(connected_component)
            result.append(component)
    
    for node in graph:
        if node not in lowlinks:
            strongconnect(node)
    
    return result

while True:
    # Keep processing nodes until the goal is found
    a = urllib2.urlopen("http://www.crunchyroll.com/tech-challenge/roaming-math/lakshmipathyarjun6@gmail.com/" + str(url_num)).read()
    
    if a == "GOAL":
        goal_url = url_num
        num_nodes = num_nodes + 1
        if not address_queue:
            break
        else:
            url_num = address_queue.pop(0)
        continue
    
    elif a == "DEADEND":
        num_nodes = num_nodes + 1
        if not address_queue:
            break
        else:
            url_num = address_queue.pop(0)
        continue
    
    # Use this to interpret what operations to perform and compute the resulting node values
    for i in a:
        s+=i
        if i == '(':
            operator_string = s.replace("(","")

            if operator_string == "abs":
                operator_stack.append("||")
            elif operator_string == "add":
                operator_stack.append("+")
            elif operator_string == "multiply":
                operator_stack.append("*")
            elif operator_string == "subtract":
                operator_stack.append("-")

            s = ""
        elif i == ',':
            operator_string = s.replace(",","")
            if operator_string == "":
                pass
            else:
                operand_stack.append(operator_string)

            s = ""

        elif i == ')':
            operator_string = s.replace(")","")
            if operator_string == "":
                pass
            else:
                operand_stack.append(operator_string)

            operation = operator_stack.pop()
            operand_1 = operand_stack.pop()

            if operation == "||":
                result = abs(int(operand_1))

            elif operation == "+":
                operand_2 = operand_stack.pop()
                result = int(operand_2) + int(operand_1)

            elif operation == "-":
                operand_2 = operand_stack.pop()
                result = int(operand_2) - int(operand_1)

            elif operation == "*":
                operand_2 = operand_stack.pop()
                result = int(operand_2) * int(operand_1)

            operand_stack.append(result)
            s = ""
        
        # Add the result of every new line to a several queues - one to keep track of the next address to process, one to keep track of the entire searched graph, and one to keep track of only unique nodes
        elif i == '\n':
            if operand_stack[0] not in history_queue:
                history_queue.append(operand_stack[0])
                address_queue.append(operand_stack[0])
                temp_queue.append(operand_stack[0])

            temp_queue_DFS.append(operand_stack[0])
            operator_stack[:] = []
            operand_stack[:] = []
            operator_string = ""
            s = ""

    # Need this to deal with the last line of every page because it is NOT terminated with a newline character
    if operand_stack[0] not in history_queue:
        history_queue.append(operand_stack[0])
        address_queue.append(operand_stack[0])
        temp_queue.append(operand_stack[0])

    temp_queue_DFS.append(operand_stack[0])

    # Start setting up the dictionaries to use when traversing the graph to find the shortest path and the number of unique cycles
    new_queue = temp_queue[:]
    path_dict[url_num] = new_queue

    newer_queue = temp_queue_DFS[:]
    cycle_dict[url_num] = newer_queue

    operator_stack[:] = []
    operand_stack[:] = []
    temp_queue[:] = []
    temp_queue_DFS[:] = []
    operator_string = ""
    s = ""
    new_url = address_queue.pop(0)
    num_nodes = num_nodes + 1
    url_num = new_url

# Find the number of unique cycles by first finding the strongly connected components
interesting_set = strongly_connected_components(cycle_dict)

# If a strongly connected component has more than one element, it must be a cycle
for i in interesting_set:
    if len(i) > 1:
        cycle_count = cycle_count + 1

# Print the results
print json.dumps({"goal": goal_url, "node_count": num_nodes, "shortest_path": find_shortest_path(path_dict,starting_node,goal_url), "directed_cycle_count": cycle_count}, indent=4, separators=(',', ': '))
