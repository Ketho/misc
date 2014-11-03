# Microsoft x64 calling convention
.text
hello:
	.asciz "Hello World"

.global _main

_main:
	pushl	$hello			# load memory address of string
	call	_printf			# call the printf subroutine
end:
	pushl	$0				# exit code
	call	_exit
