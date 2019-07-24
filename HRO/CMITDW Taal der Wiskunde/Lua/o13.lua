-- opdracht 1.3; Bol
local function Bol(r)
	local opp = 4*math.pi*r^2 -- 4pr^2
	local volume = 4/3*math.pi*r^3 -- 4/3pr^3
	return opp, volume
end

print(Bol(7)) -- 615.7521601036, 1436.7550402417
