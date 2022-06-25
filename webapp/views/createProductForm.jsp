<html>
<head>
    <title>Create product</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Amount</th>
    </tr>
    </thead>
    <tbody>
    <form action="/product/create" method="GET">
        <tr>
            <td><input type="text" name="name" required placeholder="name"/></td>
            <td><input type="number" name="price" required placeholder="price"/></td>
            <td><input type="number" name="amount" required placeholder="amount"/></td>
            <td><input type="submit" value="Create"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
