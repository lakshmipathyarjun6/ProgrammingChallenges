#!/usr/local/bin/ruby


def leastDeletions(anagram1,anagram2)
    
    h1 = Hash.new("None")
    h2 = Hash.new("None")
    total = 0
    
    anagram1.each_char do |i|
        if h1[i] == "None"
            h1[i] = 1
        else
            h1[i] = h1[i] + 1
        end
    end
    
    anagram2.each_char do |i|
        if h2[i] == "None"
            h2[i] = 1
        else
            h2[i] = h2[i] + 1
        end
    end
    
    h1.keys.each do |val|
        if h2[val] == "None"
            total += h1[val]
        end
    end
    
    h2.keys.each do |val|
        if h1[val] == "None"
            total += h2[val]
        else
            diff = h2[val] - h1[val]
            total += diff.abs
        end
    end
    
    return total
end

anagram1 = gets.chomp.to_s
anagram2 = gets.chomp.to_s

puts leastDeletions(anagram1,anagram2)