-- opdracht 3.6; Regula falsi
-- http://www.wolframalpha.com/input/?i=x%5E5-3x%5E2-2+%3D+0
-- http://commons.wikimedia.org/wiki/File:Regula_falsi.gif
local function func1(x)
	return x^5 - 3*x^2 - 2
end

local function regula(func, a, b)
	local fa = func(a)
	local fb = func(b)
	
	local c = b - fb * ((b-a) / (fb-fa))
	local fc = func(c)
	
	print(a, b, c, fc)
	
	-- avoid infinite loop to zero
	if fc > 1e-7 then
		return regula(func, a, c)
	elseif fc < -1e-7 then
	 	return regula(func, c, b)
	else
		return c
	end
end

print("f(x) = 0", regula(func1, -2, 2))
