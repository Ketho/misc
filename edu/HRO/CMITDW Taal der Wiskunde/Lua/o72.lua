-- opdracht 7.2; puzzel 2
local strfind = string.find
print("i", "i^2", "i^3", "single")

for i = 1, 1000 do
	local square, cube = i^2, i^3
	local s = square..cube
	local hasNumbers = true
	
	for j = 0, 9 do
		-- check for each number in either strings
		if not strfind(s, j) then
			hasNumbers = false
			break
		end
	end
	
	if hasNumbers then
		local single = true
		
		for j = 0, 9 do
			local _, p2 = strfind(s, j)
			-- find any second instance of number
			if strfind(s, j, p2+1) then
				single = false
				break
			end
		end
		
		print(i, square, cube, single)
	end
end
