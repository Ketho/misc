-- opdracht 6.1; reeksen
local reeks = {
	function(a)
		print("-- de natuurlijke getallen die niet te delen zijn door 4 of 5")
		local n, i = 0, 0
		
		while n < a do
			i = i + 1
			if i%4 > 0 and i%5 > 0 then
				n = n + 1
				print(n, i)
			end
		end
	end,
	function(a)
		-- http://www.wolframalpha.com/input/?i=1%2C-2%2C4%2C-8%2C16%2C-32%2C...
		print("-- 1, -2, 4, -8, 16, -32, ...")
		
		for n = 1, a do
			print(n, (-1)^(n-1) * 2^(n-1))
		end
	end,
	function(a)
		print("-- sqrt(2n - 1)")
		
		for n = 1, a do
			print(n, math.sqrt(2*n - 1))
		end
	end,
}

for _, v in ipairs(reeks) do
	v(20)
end
