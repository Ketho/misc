-- hoofdstuk 6; Fibonacci
local i = 1
local top = 100

local function fibonacci(a, b)
	i = i + 1
	local c = a + b
	print(i, c)
	if i < top then
		return fibonacci(b, c)
	end
end

-- zeroth and first term
print(0, 0)
print(1, 1)
fibonacci(0, 1)
