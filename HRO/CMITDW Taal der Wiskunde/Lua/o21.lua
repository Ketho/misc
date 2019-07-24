-- opdracht 2.1; Factorial
local function factorial(n)
	local sum = 1
	for i = 2, n do
		sum = sum * i
	end
	return sum
end

for i = 1, 200 do -- overflow vanaf 171
	print(i, factorial(i))
end
