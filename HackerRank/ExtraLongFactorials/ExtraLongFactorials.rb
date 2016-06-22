#!/usr/local/bin/ruby

def computeFactorial(n)
    if n == 1
        return 1
    else
        return n * computeFactorial(n-1)
    end
end

n = gets.strip.to_i

puts computeFactorial(n).to_s