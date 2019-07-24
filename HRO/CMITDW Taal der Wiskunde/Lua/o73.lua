-- opdracht 7.3; puzzel 3
local i = 0
local t = {} -- associative array

local function wipe(t)
	for k in pairs(t) do
		t[k] = nil
	end
end

for c = 2, 100 do
	wipe(t) -- clear table
	for a = 2, c-1 do
		local b = math.sqrt(c^2 - a^2)
		if b%1 == 0 and not t[a] then
			i = i + 1
			t[b] = true -- filter mirror value
			print(a, b, c)
		end
	end
end
