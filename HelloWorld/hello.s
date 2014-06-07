.text
s : .asciz "Hello World!"

.global _main

_main:	pushl	$s			# push the string
		call	_printf		# print the text
		
end:	pushl	$0			# push program exit code
		call	_exit		# exit the program
