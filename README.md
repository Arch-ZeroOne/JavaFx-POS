# WordPress Functions Reference Notes

## ob_start()
- **Purpose:** Captures output and stores it in memory (buffer) instead of sending to browser immediately
- **Use Case:** Allows you to collect HTML output and return it as a value or process it before display
- **Simple analogy:** Like hitting record on a video camera before displaying content

## the_post_thumbnail()
- **Purpose:** Displays the featured image (thumbnail) of a post
- **Basic syntax:** `the_post_thumbnail();`
- **With size:** `the_post_thumbnail('medium');`
- **Available sizes:** `'thumbnail'`, `'medium'`, `'large'`, `'full'`
- **With custom class:** `the_post_thumbnail('large', array('class' => 'my-custom-class'));`
- **Get URL instead:** `get_the_post_thumbnail_url();`

## get_the_date()
- **Purpose:** Retrieves the publication date of a post
- **Basic syntax:** `echo get_the_date();`
- **Custom format:** `get_the_date('Y-m-d');`
- **Common formats:**
  - `'F j, Y'` → November 1, 2025
  - `'Y-m-d'` → 2025-11-01
  - `'d/m/Y'` → 01/11/2025
  - `'l, F j'` → Saturday, November 1

## coffee_kinds() Function Overview
- Displays a list of posts (blog articles)
- Takes attributes with default type of `'news'`
- Queries WordPress database for posts
- Loops through and displays each post with image, title, and content
- Limited to 10 posts per page, sorted by date (oldest to newest)
