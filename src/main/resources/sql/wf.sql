select tc.person_id as person_id,
       row_number() over (partition by tc.person_id order by "order") as rn
from title_crew tc