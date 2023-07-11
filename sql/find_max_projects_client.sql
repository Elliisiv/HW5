SELECT nameCl c_lient,
       cl.cnt client_max
FROM (SELECT (SELECT name FROM client WHERE id = p.client_id) nameCl,
                count(*) cnt
         FROM project p
         GROUP BY client_id) cl
WHERE  cnt = (SELECT max(cnt) FROM (SELECT client_id,
                                           count(*) cnt
                                    FROM project p
                                    GROUP BY client_id) cll)
GROUP BY nameCl,cl.cnt;
