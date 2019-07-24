local n = 600 -- amount of terms
local i = 2 -- start from 3rd term

local function alg1(a, b)
	i = i + 1
	local c = (i*b) / a
	print(i, a, b, c)
	
	if i < n then
		alg1(b, c)
	end
end

print("i", "n-2", "n-1", "n")
alg1(1, 3)
