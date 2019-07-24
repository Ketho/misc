.text
assignment:
	.asciz "Assignment 4: factorial"
enternumber:
	.asciz "Please enter number n:"
scanarg:
	.asciz "%ld"			# long digit (64 bits)
output:
	.asciz "Outcome of factorial(n) =\n%d\n"

.global	main

# %rdi = arg a
# %rsi = arg b
main:
	# assignment info
	movq	$assignment, %rdi
	call	puts
	
	# ask for input
	movq	$enternumber, %rdi
	call	puts
	call	inout
	movq	%rax, %rdi
	
	# call factorial subroutine
	call	factorial
	
	# show the calculated number
	movq	%rax, %rsi
	movq	$output, %rdi
	movq	$0, %rax		# zero vector registers used
	call	printf
	
	# exit program
	movq	$0, %rdi
	call	exit

  ###########
  ## inout ##
  ###########

# -8(%rbp) = stack var x
# %rax = return value
inout:
	# subroutine prologue
	pushq	%rbp
	movq	%rsp, %rbp
	subq	$8, %rsp		# reserve stack space (for lea)
	
	# scan the number
	leaq	-8(%rbp), %rsi		# memory address to store scan input in
	movq	$scanarg, %rdi		# string with scan arguments
	movq	$0, %rax		# zero vector registers used
	call	scanf
	
	popq	%rax			# move input value to %rax
	
	# subroutine epilogue
	movq	%rbp, %rsp
	popq	%rbp
	ret

  ###############
  ## factorial ##
  ###############

# %rdi = arg a
# -8(%rbp) = stack var x
# %rax = return value (sum)
# returns 1 for factorial(0)
factorial:
	# subroutine prologue
	pushq	%rbp
	movq	%rsp, %rbp
	
	# if a less or equals 1; jump out of the recursive subroutine
	cmpq	$1, %rdi
	jle	factthen	# if (a <= 1)
	
	# store a on the stack as x; keep decrementing a and pass it to the next call
	pushq	%rdi		# x = a
	decq	%rdi		# a--
	
	# start the recursive call
	call	factorial
	
	# stopped recursing; now just multiply sum(initially 1) with each stack var x(= 2, 3, 4, ...)
	mulq	-8(%rbp)	# sum *= x
	jmp	factend
	
factthen:
	# turning point; deepest point of recursion
	movq	$1, %rax	# sum = 1
	
factend:
	# subroutine epilogue
	movq	%rbp, %rsp
	popq	%rbp
	ret

