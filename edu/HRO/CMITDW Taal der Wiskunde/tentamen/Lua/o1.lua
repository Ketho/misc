-- -(i*2-1)^3 / i -+ ...
local function alg1(n)
	local sum = 0
	local op = true
	
	for i = 1, n do
		if op then
			sum = sum - ((i*2-1)^3) / i
		else
			sum = sum + ((i*2-1)^3) / i
		end
		
		op = not op -- toggle boolean
		print(i, sum)
	end
	
	return sum
end

print(alg1(600))
