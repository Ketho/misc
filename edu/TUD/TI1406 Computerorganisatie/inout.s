.text
assignment:
	.asciz "Assignment 2: inout"
enternumber:
	.asciz "Please enter a number:"
scanarg:
	.asciz "%d"
outputnumber:
	.asciz "This number incremented by one:\n%d\n"

.global	main

main:
	# show current assignment info
	movq	$assignment, %rdi
	call	puts
	
	# ask for a number
	movq	$enternumber, %rdi
	call	puts
	
	# call inout subroutine
	call	inout
	incq	%rax			# increment number by 1
	
	# show the (incremented) number
	movq	%rax, %rsi
	movq	$outputnumber, %rdi
	movq	$0, %rax		# zero vector registers
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

