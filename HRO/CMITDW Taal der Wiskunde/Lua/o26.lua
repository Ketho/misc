-- opdracht 2.6; Sigmoidefunctie
-- http://www.wolframalpha.com/input/?i=1%2F%281%2Bexp%28-t%29%29
local function sigmoide(t)
	return 1 / (1 + math.exp(-t))
end

local vmin
local vmax

for i = -10, 10 do
	local s = sigmoide(i)
	vmin = math.min(vmin or 1337, s)
	vmax = math.max(vmax or 0, s)
	print(i, s)
end

print(vmin, vmax) -- range = [0 ; 1]
