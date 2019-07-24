-- opdracht 1.4; PI
local t = {}

for i = 1, 8 do
	t[10^i] = i -- 10, 100, 1000, ...
end

-- just to iterate over the functions later
local PI = {}

-- PI1: pi/4 = 1/1 - 1/3 + 1/5 - 1/7 + ...
PI[1] = function(top)
	local sum = 0
	local delta = os.clock()
	local op = true
	
	for i = 1, top do
		if op then
			sum = sum + 1 / (i*2-1)
		else
			sum = sum - 1 / (i*2-1)
		end
		op = not op -- toggle boolean
		
		if t[i] then
			print(t[i], sum, math.pi/4-sum, os.clock()-delta)
			delta = os.clock()
		end
	end
end

-- PI2: (pi^2)/12 = 1/(1^2) - 1/(2^2) + 1/(3^2) - 1/(4^2) + ...
PI[2] = function(top)
	local sum = 0
	local delta = os.clock()
	local op = true
	
	for i = 1, top do
		if op then
			sum = sum + 1 / i^2
		else
			sum = sum - 1 / i^2
		end
		op = not op
		
		if t[i] then
			print(t[i], sum, math.pi^2/12-sum, os.clock()-delta)
			delta = os.clock()
		end
	end
end

-- PI3: (pi^2)/6 = 1/(1^2) + 1/(2^2) + 1/(3^2) + 1/(4^2) + ...
PI[3] = function(top)
	local sum = 0
	local delta = os.clock()
	
	for i = 1, top do
		sum = sum + 1 / i^2
		if t[i] then
			print(t[i], sum, math.pi^2/6-sum, os.clock()-delta)
			delta = os.clock()
		end
	end
end

-- PI4: (pi^2)/8 = 1/(1^2) + 1/(3^2) + 1/(5^2) + 1/(7^2) + 1/(9^2) + ...
PI[4] = function(top)
	local sum = 0
	local delta = os.clock()
	
	for i = 1, top do
		sum = sum + 1 / (i*2-1)^2
		if t[i] then
			print(t[i], sum, math.pi^2/8-sum, os.clock()-delta)
			delta = os.clock()
		end
	end
end

for i, v in ipairs(PI) do
	print("algoritme PI"..i)
	v(1e8)
end
