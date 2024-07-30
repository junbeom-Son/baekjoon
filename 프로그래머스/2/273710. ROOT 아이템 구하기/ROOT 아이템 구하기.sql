select info.item_id, info.item_name
from item_info info join item_tree using(item_id)
where item_tree.parent_item_id is null;