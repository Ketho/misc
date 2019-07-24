-- opdracht 3.2; abc-formule; oplossingen
local a = { 3,-2, .5,  1, 2, 0, 2}
local b = { 2, 3, .3,  0, 5, 5, 0}
local c = {-5, 0,-.2,-25, 4, 3, 0}

for i = 1, #a do
	local D = b[i]^2 - (4 * a[i] * c[i])
	
	if a[i] == 0 then
		print(i, "Er zijn geen oplossingen (a == 0)")
	elseif D < 0 then
		print(i, "Er zijn geen oplossingen (D < 0)")
	elseif D == 0 then
		print(i, "Er is een oplossing, namelijk x = "..-b[i]/(2*a[i]))
	elseif D > 0 then
		local v1 = math.sqrt(D)
		local v2 = 2 * a[i]
		
		local x1 = (-b[i] + v1) / v2 -- positive
		local x2 = (-b[i] - v1) / v2 -- negative
		
		print(i, "Er zijn twee oplossingen, namelijk x1 = "..x1.."\tx2 = "..x2)
	end
end
