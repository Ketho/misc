-- opdracht 2.3; e^3
local function factorial(n)
	local sum = 1
	for i = 2, n do
		sum = sum * i
	end
	return sum
end

local function sigma(a, b)
	local sum = 0
	for n = a, b do
		sum = sum + (3^n / factorial(n))
		print(n, sum, 3^n / factorial(n), math.exp(3)-sum)
	end
	return sum
end

print(sigma(0, 28)) -- 20.085536923188
