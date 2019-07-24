
local function alg1(x)
	return x^3 + 40*x^2 + 10
end

local function bisect(left, right)
	local mid = (left + right) / 2
	local fmid = alg1(mid)
	
	print(left, right, mid, fmid)
	
	if fmid > 1e-7 then
		return bisect(left, mid)
	elseif fmid < -1e-7 then
		return bisect(mid, right)
	else
		return mid
	end
end

print("f(x) = 0\t", bisect(-50, 50))
