-- opdracht 5.2; variantie, standaarddeviatie
local len = {}

for i = 1, 300 do -- number of lengths
	len[i] = math.random(160, 199)
end

local function average(t)
	local sum = 0
	
	for _, v in pairs(t) do
		sum = sum + v
	end
	
	return sum / #t
end

local function variance(t)
	local avg = average(t)
	local sum = 0
	
	for _, v in pairs(t) do
		sum = sum + (v - avg)^2
	end
	
	return sum / #t
end

local function explode(t)
	for i, v in ipairs(t) do
		print(i, v)
	end
end

explode(len)

local var = variance(len)

print("variance =", var)
print("standard deviation =", math.sqrt(var))
