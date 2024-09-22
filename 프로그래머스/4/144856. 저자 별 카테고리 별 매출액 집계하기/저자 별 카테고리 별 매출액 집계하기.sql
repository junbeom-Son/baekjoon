-- 코드를 입력하세요
SELECT AUTHOR_ID, AUTHOR_NAME, CATEGORY, sum(sales) as TOTAL_SALES
FROM (
    select book_id, author_id, author_name, category, sales * price as sales
    from book join author using(author_id) join book_sales using(book_id)
    where sales_date like '2022-01%'
) tmp
group by author_id, category
order by author_id, category desc;


# book1 = 45
# select book_id, author_id, author_name, category, sales * price as sales
# from book join author using(author_id) join book_sales using(book_id)
# where sales_date like '2022-01%'
# group by book_id
# order by author_id, category desc;

# select book_id, author_id, author_name, category, sales, price, sales_date
# from book join author using(author_id) join book_sales using(book_id)
# where sales_date like '2022-01%'
# order by author_id, category desc;