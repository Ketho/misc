-- opdracht 3.1; abc-formule
local a = { 3,-2, .5,  1, 2, 0}
local b = { 2, 3, .3,  0, 5, 5}
local c = {-5, 0,-.2,-25, 4, 3}

for i = 1, #a do
	local v1 = math.sqrt(b[i]^2 - (4 * a[i] * c[i]))
	local v2 = 2 * a[i]
	
	local x1 = (-b[i] + v1) / v2 -- positive
	local x2 = (-b[i] - v1) / v2 -- negative
	
	print(a[i], b[i], c[i], x1, x2)
end
