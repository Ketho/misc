# ************************************************************************
# * Program name :	sieve												 *
# * Description  :	this program prints all the prime numbers below 1000 *
# ************************************************************************
.bss
NUMBERS: .skip 1000					# memory space for the number table

.text
formatstr: .asciz "%d "				# format string for number printing

.global main

# ************************************************************************
# * Subrout ine : main													 *
# * Description : application entry point								 *
# ************************************************************************
main:
		movq	%rsp, %rbp				# i n i t i a l i z e the base po int e r
										# I n i t i a l i z e the number t ab l e
		movq	$0, %rbx				# i n i t i a l i z e ' i ' to 0 .
loop1:
		movb	$1, NUMBERS(%rbx)		# s e t number t ab l e ent ry ' i ' to ' t rue '
		incq	%rbx					# increment ' i '
		cmpq	$1000, %rbx				# whi l e ' i ' < 1000
		jl		loop1					# go to s t a r t o f loop1

# The s i e v e algor i thm :
		pushq	$2						# i n i t i a l i z e ' number ' to 2 on s tack
loop2:
		movq	-8(%rbp), %rbx			# load ' number ' int o a r e g i s t e r
		cmpb	$1, NUMBERS(%rbx)		# compare NUMBERS[ number ] to '1 '
		jne		lp2end					# i f not equal, jump to end o f loop 2
		movq	$formatstr, %rdi		# f i r s t argument : f o rma t s t r
		movq	%rbx, %rsi				# second argument : the number
		movq	$0, %rax				# no ve c t o r arguments
		call	printf					# pr int the number
		movq	-8(%rbp), %rbx			# ' mul t ipl e ' := ' number '
		shlq	$1, %rbx				# mul t iply ' mul t ipl e ' by 2
loop3:
		cmpq	$1000, %rbx				# compare ' mul t ipl e ' to 1000
		jge		lp2end					# goto end o f loop2 i f g r e a t e r / equal
		movb	$0, NUMBERS(%rbx)		# s e t number t ab l e ent ry to ' f a l s e '
		addq	-8(%rbp), %rbx			# add another ' number ' to ' mul t ipl e '
		jmp		loop3					# jump to the beginning o f loop 3
lp2end:
		movq	-8(%rbp), %rbx			# load ' number ' int o a r e g i s t e r
		incq	%rbx					# increment ' number ' by one
		movq	%rbx, -8(%rbp)			# s t o r e ' number ' on the s tack
		cmpq	$1000, %rbx				# compare ' number ' to 1000
		jl		loop2					# i f smal l e r, r epe a t loop2
end:
		mov		$0, %rdi				# load program e x i t code
		call	exit					# e x i t the program
