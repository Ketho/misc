-- opdracht 5.3; Monte Carlo methode
local p = 15 * 18 -- 15 plaatjes, 18 teams
local t = {}

local function wipe(t)
	for k in pairs(t) do
		t[k] = nil
	end
end

local function MonteCarlo()
	wipe(t)
	local i = 0
	
	while #t ~= p do
		i = i + 1 -- pakjes
		
		for j = 1, 5 do -- 5 plaatjes per pakje
			t[math.random(p)] = true
		end
	end
	
	return i
end

local sum = 0
local n = 100 -- amount of tests

for i = 1, n do
	local result = MonteCarlo()
	sum = sum + result
	print(i, result)
end

print(sum/n.." * 10 euro gemiddeld uitgegeven")
