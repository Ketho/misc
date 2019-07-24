-- opdracht 2.5; Sinus hyperbolicus
local function sinh(x)
	return (math.exp(x) - math.exp(-x)) / 2
end

for i = 0, 10 do
	print(i, sinh(i))
	--print(i, math.sinh(i)) -- cheat
end
