# Microsoft x64 calling convention
.text
hello: .asciz "Hello World!\n"

.global main

main:
		movq	$hello, %rcx	# first argument, load memory address of string
		movq	$0, %rax		# number of vector registers used for printf is zero
		call	printf			# call the printf subroutine
end:
		movq	$0, %rcx
		call	exit
