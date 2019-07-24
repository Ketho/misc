
local function round(num)
	return math.floor(num + .5)
end

local function average(t)
	local sum = 0
	for _, v in pairs(t) do
		sum = sum + v
	end
	return sum / #t
end

local function mode(t)
	local v, max = 0, 0
	
	for i = 1, #t do
		local count = 0
		for j = 1, #t do
			if t[i] == t[j] then
				count = count + 1
			end
		end
		if count > max then
			max = count
			v = t[i]
		end
	end
	
	return v
end
	
local function median(t)
	table.sort(t)
	local med = #t / 2
	
	if #t%2 == 0 then
		return (t[med-1] + t[med]) / 2
	else
		return t[med]
	end
end
	
local function variance(t)
	local avg = average(t)
	local sum = 0
	for _, v in ipairs(t) do
		sum = sum + (v-avg)^2
	end
	return sum / #t
end

-- debug methods
local function explode(t)
	for i, v in ipairs(t) do
		print(i, v)
	end
end

local function verifymode(t, a, b)
	for i = a, b do
		local sum = 0
		for _, v in ipairs(t) do
			if (v == i) then
				sum = sum + 1
			end
		end
		print("mode "..i.." = "..sum)
	end
end

local array = {}

for i = 1, 600 do
	array[i] = (1 + (120 + round(100 / math.sin(i))) % 5)
end

do
	--explode(array)
	--verifymode(array, 1, 5)
	
	print("average = "..average(array))
	print("mode = "..mode(array))
	print("median = "..median(array))
	
	local var = variance(array)
	print("variance = "..var)
	print("standard deviation = "..math.sqrt(var))
end
