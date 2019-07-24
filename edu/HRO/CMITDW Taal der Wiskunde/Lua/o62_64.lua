-- opdracht 6.2 - 6.4; recursie, somrij, verschilrij
local i = 2 -- start from 3rd term
local sum = 2 + 1 -- t(1) + t(2)

-- for single line printing
local t = {
	{2, 1}, -- termen / terms
	{2, 3}, -- somrij / sigma
	{-1}, -- verschilrij / delta
}

local function func1(a, b)
	i = i + 1
	sum = sum + b/a
	local c = b/a
	print(i, a, b, c, c-b, sum)
	
	-- for single line printing
	table.insert(t[1], c)
	table.insert(t[2], sum)
	table.insert(t[3], c - b)
	
	if i < 100 then
		return func1(b, c)
	end
end

print("i", "a; n-2", "b; n-1", "b/a", "b/a - b", "sum")
print(1, nil, nil, 2, nil, 2)
print(2, nil, 2, 1, -1, 3)
func1(2, 1)

-- for single line printing
print("\ntermen t(n) =", table.concat(t[1], ", "))
print("verschilrij t(n) =", table.concat(t[3], ", "))
print("somrij t(100) =", t[2][100])
