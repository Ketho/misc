-- opdracht 3.4; Halveringsmethode
-- http://en.wikipedia.org/wiki/File:Bisection_method.svg
local f = {
	-- http://www.wolframalpha.com/input/?i=x%5E5-3x%5E2-2%3D0
	function(x)
		return x^5 - 3*x^2 - 2
	end,
	-- http://www.wolframalpha.com/input/?i=e-abs%283x%29%3D0
	function(x)
		return math.exp(1) - math.abs(3*x)
	end,
	-- http://www.wolframalpha.com/input/?i=%28x%5E2%2B4%29%2F%28x%2B2%29%3D8.5
	function(x)
		return (x^2+4)/(x+2) - 8.5
	end,
}

local function bisect(func, a, b)
	local c = (a + b) / 2
	local fc = func(c)
	
	print(a, b, c, fc)
	
	-- avoid infinite loop to zero
	if fc > 1e-7 then
		return bisect(func, a, c)
	elseif fc < -1e-7 then
		return bisect(func, c, b)
	else
		return c
	end
end

for _, v in ipairs(f) do
	print("f(x) = 0", bisect(v, -50, 50), "\n")
end
