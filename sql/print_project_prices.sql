SELECT
    p.ID AS project_id,
    p.START_DATE,
    p.FINISH_DATE,
    SUM(w.SALARY * DATEDIFF('MONTH', p.START_DATE, p.FINISH_DATE)) AS project_cost
FROM
    project p
JOIN
    project_worker pw ON p.ID = pw.PROJECT_ID
JOIN
    worker w ON pw.WORKER_ID = w.ID
GROUP BY
    p.ID, p.START_DATE, p.FINISH_DATE
ORDER BY
    project_cost DESC;