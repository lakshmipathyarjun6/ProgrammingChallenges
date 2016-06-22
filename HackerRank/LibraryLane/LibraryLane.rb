#!/usr/local/bin/ruby

def computeFine(actualreturnday,actualreturnmonth,actualreturnyear,expectedreturnday,expectedreturnmonth,expectedreturnyear)
    fine = 0
    
    if actualreturnyear > expectedreturnyear
        fine = 10000
    elsif actualreturnyear == expectedreturnyear
        if actualreturnmonth > expectedreturnmonth
            fine = 500 * (actualreturnmonth - expectedreturnmonth)
        elsif actualreturnmonth == expectedreturnmonth
            if actualreturnday >= expectedreturnday
                fine = 15 * (actualreturnday - expectedreturnday)
            end
        end
    end
    
    return fine
end


d1,m1,y1 = gets.strip.split(' ')
d1 = d1.to_i
m1 = m1.to_i
y1 = y1.to_i

d2,m2,y2 = gets.strip.split(' ')
d2 = d2.to_i
m2 = m2.to_i
y2 = y2.to_i

puts computeFine(d1,m1,y1,d2,m2,y2).to_s
