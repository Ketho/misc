local numbers = {4, 6, 8, 10, 12, 14}
local times = {}
local bingo = {} -- bingo card

local function wipe(t)
	for k in pairs(t) do
		t[k] = nil
	end
end

local function check(t)
	for _, v in ipairs(numbers) do
		if not t[v] then
			return false
		end
	end
	return true
end

local function average(t)
	local sum = 0
	for _, v in ipairs(t) do
		sum = sum + v
	end
	return sum / #t
end

for i = 1, 1e5 do -- number of times
	local tries = 0
	wipe(bingo)
	
	while (true) do
		tries = tries + 1
		local sum = 0
		
		for j = 1, 3 do
			sum = sum + math.random(6)
		end
		
		--print(sum)
		bingo[sum] = true
		
		if check(bingo) then
			times[i] = tries
			--print(i, tries)
			break
		end
	end
end

print(average(times))
