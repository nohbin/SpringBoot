# SpringBoot

select 
q.subject 제목, q.content 원문, q.create_date 질문작성일, a.content 답변, a.create_date 답변작성일
from question q
left join answer a
on q.id = a.question_id;
