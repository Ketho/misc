-- opdracht 6.5; Priemgetallen; Zeef van Eratosthenes
local t = {}
local n = 1e6
local i = 0 -- index of the prime number

for p = 2, n do -- number to be checked
	if not t[p] then
		i = i + 1
		if p <= 100 or p >= 999900 then -- skip bulk
			print(i, p)
		end
		
		for j = p*2, n, p do
			t[j] = true
		end
	end
end
