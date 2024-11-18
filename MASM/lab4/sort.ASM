DATA SEGMENT

DATA ENDS
SSTACK SEGMENT STACK
                    DW 100 DUP(?)
SSTACK ENDS
CODE SEGMENT
                    ASSUME CS:CODE,DS:DATA
START: MOV AX,000H
                MOV DS,AX
                MOV SI,3000H
                MOV CX,008H
                CALL BRANCH
HEARE: JMP HEARE

BRANCH PROC NEAR
                  JCXZ A4           ;如果cx为0,跳转到A4
                  PUSH SI
                  PUSH CX 
                  PUSH BX
                  MOV BH,[SI]   ;将SI指向段元的值复制到BH 
                  MOV BL,BH     ;将BH中的值复制到BL
                  CLD                    ;字符串操作指令中数据按照地底之低地址到高地址处理
A1:            LODSB             ;将SI指向单元的内容加载到AL寄存器,并且SI自增
                  CMP AL,BH     ;将AL与BH比较
                  JBE A2            ;如果AL<BH,跳转到A2
                  MOV BH,AL     ;否则将AL复制到BL
                  JMP A3             ;跳转到A3
A2:           CMP AL,BL     ;将AL,BL比较
                  JAE A3            ;如果AL>BL,跳转到A3
                  MOV BL,AL    ;否则将AL复制到BL
A3:            LOOP A1        ;循环A1
                  MOV AX,BX    ;将BX复制到AX
                  POP BX            ;将BX,CX,SI出栈
                  POP CX
                  POP SI
A4:            RET                  ;返回调用BRANCH子程序的地方
BRANCH  ENDP            ;子程序结束
CODE ENDS
            END START
                 
