-- opdracht 3; Priemgetallen
local i = 0 -- index of the prime number
local p = 1 -- number to be checked

while i < 200 do
	p = p + 1
	local isprime = true
	
	for j = 2, p-1 do
		if p%j == 0 then
			isprime = false
			break
		end
	end
	
	if isprime then
		i = i + 1
		print(i, p)
	end
end
