-- prime numbers consisting of only numbers 3 and 4
local numbers = {0, 1, 2, 5, 6, 7, 8, 9}
local n = 1e6 -- number to be checked
local i = 0 -- index of the (special) prime number
local t = {}

-- Sieve of Eratosthenes (very efficient)
for p = 2, n do
	if not t[p] then
		local special = true
		
		for _, v in ipairs(numbers) do
			-- check for anything not 3 and not 4
			if string.find(p, v) then
				special = false
				break
			end
		end
		
		if special then
			i = i + 1
			print(i, p)
		end
		
		for j = p*2, n, p do
			t[j] = true
		end
	end
end

