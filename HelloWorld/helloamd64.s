# Unix/AMD64 calling convention
.text
hello:
	.asciz "Hello World!\n"

.global main

main:
	movq	$hello, %rdi	# load memory address of string
	movq	$0, %rax	# no vector registers used
	call	printf		# call the printf subroutine
end:
	movq	$0, %rdi	# exit code
	call	exit

