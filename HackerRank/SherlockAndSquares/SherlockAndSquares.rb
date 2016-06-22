#!/usr/local/bin/ruby


def findInBetweenSquares(lb, ub)
    total = 0
    
    start = Math.sqrt(lb).floor
    
    until start**2 > ub do
        if start**2 >= lb and start**2 <= ub
            total += 1
        end
        start += 1
    end
    
    return total
end


num_cases = gets.to_i
i = 0

cases = Array.new

while i < num_cases
    cases.push(gets.chomp.to_s)
    i += 1
end

cases.each do |str|
    splitstr = str.split
    lb = splitstr[0].to_i
    ub = splitstr[1].to_i
    puts findInBetweenSquares(lb,ub)
end