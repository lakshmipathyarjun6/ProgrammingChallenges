#!/usr/local/bin/ruby

def encodeString(n,s,k)
    
    encryptedString = ""
    
    s.each_byte do |val|
        
        replacementCharVal = 0
        
        if(/[[:alpha:]]/.match(val.chr))
            if(/[[:upper:]]/.match(val.chr))
                replacementCharVal = ((val - 65 + k) % 26) + 65
            else
                replacementCharVal = ((val - 97 + k) % 26) + 97
            end
        else
            replacementCharVal = val
        end
        
        encryptedString << (replacementCharVal).chr
        
    end
    
    return encryptedString
end


n = gets.strip.to_i
s = gets.strip
k = gets.strip.to_i

puts encodeString(n, s, k)