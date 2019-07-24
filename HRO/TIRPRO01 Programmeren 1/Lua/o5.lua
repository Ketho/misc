-- opdracht 5; Priemgetallen; Zeef van Eratosthenes
local t = {}
local n = 2000 -- some random high enough number
local i = 0 -- index of the prime number

for p = 2, n do -- number to be checked
	if i >= 200 then
		break
	end
	
	if not t[p] then
		i = i + 1
		print(i, p)
		
		for j = p*2, n, p do
			t[j] = true
		end
	end
end
