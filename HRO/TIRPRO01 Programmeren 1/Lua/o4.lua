-- opdracht 4; Binomium van Newton
local function factorial(n)
	local sum = 1
	for i = 2, n do
		sum = sum * i
	end
	return sum
end

local function binomial(a, b)
	return factorial(a) / (factorial(b) * factorial(a-b))
end

local function binomium(n, a, b)
	local sum = 0
	for k = 0, n do
		sum = sum + binomial(n, k) * a^k * b^(n-k)
	end
	return sum
end

print(factorial(3)) -- 6
print(binomial(5, 3)) -- 10
print(binomium(2, 1, 2)) -- 9
