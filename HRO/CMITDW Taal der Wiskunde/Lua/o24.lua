-- opdracht 2.4; e^x
local t = {
	0,
	4,
	-1, -- 1/e
	.5, -- math.sqrt(e)
}

for _, v in ipairs(t) do
	print(v, math.exp(v))
end
