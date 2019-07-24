-- opdracht 5.1; gemiddelde, modus, mediaan

local len = {}

for i = 1, 300 do -- number of lengths
	len[i] = math.random(160, 199)
end

local function average(t)
	local sum = 0
	
	for _, v in pairs(t) do
		sum = sum + v
	end
	
	return sum / #t
end

local function mode(t)
	local tmodus = {}
	
	-- reverse table
	for _, v in pairs(t) do
		tmodus[v] = (tmodus[v] or 0) + 1
	end
	
	local modusK
	local modusV = 0
	
	for k, v in pairs(tmodus) do
		if v > modusV then
			modusV = v
			modusK = k
		end
	end
	
	return modusK, modusV
end

local function median(t)
	table.sort(t)
	
	local med
	local tsize = #t
	
	if tsize%2 == 1 then
		med = t[(tsize+1)/2]
	else
		med = (t[tsize/2] + t[tsize/2+1]) / 2
	end
	
	return med
end

local function explode(t)
	for i, v in ipairs(t) do
		print(i, v)
	end
end

explode(len)

print("average =", average(len))
print(string.format("modus =\t%s\t(%sx)", mode(len)))
print("median =", median(len))

--explode(len) -- table is sorted now
