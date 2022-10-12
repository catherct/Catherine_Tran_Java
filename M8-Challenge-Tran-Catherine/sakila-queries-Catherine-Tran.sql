-- Write a SQL query to find the total rental amount paid for each film.
SELECT f.film_id, SUM(amount) AS 'total_amount'
FROM payment AS p
JOIN rental AS r
ON (p.rental_id = r.rental_id)
	JOIN inventory AS i
	ON (i.inventory_id = r.inventory_id)
		JOIN film AS f
		ON (f.film_id = i.film_id)
GROUP BY f.film_id;


-- Create a view named total_rental_amount using the query from the previous step ( + queried table view)
CREATE VIEW total_rental_amount AS
SELECT f.film_id, SUM(amount) AS 'total_amount'
FROM payment AS p
JOIN rental AS r
ON (p.rental_id = r.rental_id)
	JOIN inventory AS i
	ON (i.inventory_id = r.inventory_id)
		JOIN film AS f
		ON (f.film_id = i.film_id)
GROUP BY f.film_id;


SELECT *
FROM total_rental_amount;


-- Write a SQL query to find the total number of copies in inventory for each film.
SELECT film_id, COUNT(film_id) AS 'total_copies'
FROM inventory i
GROUP BY film_id;


-- Create a view named total_film_copies using the query from the previous step (+ queried table view)
CREATE VIEW total_film_copies AS
SELECT film_id, COUNT(film_id) AS 'total_copies'
FROM inventory i
GROUP BY film_id;

SELECT *
FROM total_film_copies;


-- Write a SQL query that combines data from the film table, the total_rental_amount view, and the total_film_copies view to find all films with a total rental amount greater than 200.00.
SELECT f.film_id, f.title, f.description, f.rental_duration, f.rental_rate, f.replacement_cost, f.rating, tfc.total_copies, tra.total_amount
FROM film AS f
JOIN total_film_copies tfc 
ON (f.film_id = tfc.film_id)
	JOIN total_rental_amount tra 
	ON (tra.film_id = tfc.film_id)
		WHERE total_amount > 200.00
GROUP BY f.film_id;
