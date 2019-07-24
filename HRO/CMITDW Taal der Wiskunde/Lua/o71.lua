-- opdracht 7.1; puzzel 1
print("/5", "square", "prime")

for i = 1, 1000 do
	if i%5 == 0 then -- dividable by 5
		if math.sqrt(i+1)%1 == 0 then -- quadratic
			local isprime = true
			for j = 2, i+1 do
				if (i+2)%j == 0 then -- not prime
					isprime = false
					break
				end
			end
			if isprime then
				print(i, i+1, i+2)
			end
		end
	end
end
