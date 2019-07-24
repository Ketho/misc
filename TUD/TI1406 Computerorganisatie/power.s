.text
assignment:
	.asciz "Assignment 3: power"
scanx:
	.asciz "Please enter number x:"
scany:
	.asciz "Please enter number y:"
scanarg:
	.asciz "%ld"			# long digit (64 bits)
output:
	.asciz "Outcome of x^y =\n%d\n"

.global main

# %rdi = arg a
# %rsi = arg b
#  -8(%rbp) = stack var x
# -16(%rbp) = stack var y
main:
	# print assignment info
	movq	$assignment, %rdi
	call	puts
	
	# ask number x
	movq	$scanx, %rdi
	call	puts

	# scan number x
	call	inout
	pushq	%rax			# store first scan return x in stack -8(%rbp)
					# before calling inout again
	# ask number y
	movq	$scany, %rdi
	call	puts

	# scan number y
	call	inout
	
	# move the first and second scan inputs to input registers
	popq	%rdi			# store x from stack in arg a
	movq	%rax, %rsi		# store second scan return in arg b
	
	# call power subroutine
	call	power
	
	# show the calculated number
	movq	%rax, %rsi
	movq	$output, %rdi
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

  ###########
  ## power ##
  ###########

# %rdi = arg x (base)
# %rsi = arg y (exponent)
# %rax = return value (sum)
# returns 1 for exponent == 0
# returns 0 for base == 0
power:
	# subroutine prologue
	pushq	%rbp
	movq	%rsp, %rbp
	
	# start with sum initialized to 1
	movq	$1, %rax		# sum = 1
	
	## loop start
	jmp	loop1cond
loop1:
	decq	%rsi			# exponent--
	mulq	%rdi			# sum *= base
	
loop1cond:
	cmpq	$0, %rsi
	jg loop1			# exponent > 0
	## loop end
	
	# subroutine epilogue
	movq	%rbp, %rsp
	popq	%rbp
	ret

