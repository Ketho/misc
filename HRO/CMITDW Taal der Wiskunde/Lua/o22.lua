-- opdracht 2.2; Productsymbool
local function product(a, b)
	local sum = 1
	for i = a, b do
		sum = sum * (i / (i + 1))
		print(i, sum)
	end
	return sum
end

print(product(1, 99))
